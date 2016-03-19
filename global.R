library(rPython)

python.load("preprocessors.py")

# load the libraries for decision tree classification
python.exec("
from sklearn.tree import DecisionTreeClassifier
from sklearn import tree
")

# load the classifier
python.exec("
with open('my_dumped_dtclassifier.pkl', 'rb') as fid:
  clf = cPickle.load(fid)
")