library(shiny)
library(rPython)
library(ggplot2)

shinyServer(function(input, output) {

  output$outputText <- renderText({
    
    inFile <- input$file1
    
    if(is.null(inFile))
      return(NULL)
    python.assign("filename",inFile$datapath)
    python.exec("
                instance = Preprocessor('grib','nothing')
                table = instance.computeOnlyFingerPrint(filename)
                output = clf.predict(table)
                ")
    table <- python.get("table")
    print(table)
    
    output$plot <- renderPlot({
      xVal <- seq(1,256)
      df <- data.frame(xVal, table)
      ggplot(df, aes(x = xVal, y = table)) + geom_line()
    })
    
    classifiedFile <- python.get("output[0]")
    classifiedFileText <- ""
    if(classifiedFile == 1) {
      classifiedFileText <- "It is a Grib File"
    } else {
      classifiedFileText <- "It is not a Grib File"
    }
    return(toString(classifiedFileText))
    
  })

})
