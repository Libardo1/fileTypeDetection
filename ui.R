library(shiny)
library(shinydashboard)

dashboardPage(
  dashboardHeader(title = "File Detector"),
  dashboardSidebar(
    fileInput('file1', 'Choose CSV File')
  ),
  dashboardBody(
    fluidRow(
      box(title = "What is the file Type?",solidHeader = TRUE, status = "primary", textOutput('outputText')),
      box(
        title = "Frequency Analysis Diagram",solidHeader = TRUE, status = "primary",
        plotOutput("plot")
      )
    )
  )
)

