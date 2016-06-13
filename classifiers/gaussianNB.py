#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
# 
#    http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# 
#

from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score

class GaussianNBClassifier:

	def __init__(self):
		"""
		This is the constructor responsible for initializing the classifier
		"""
		self.outputHeader = "#gnb"
		self.clf = None

	def buildModel(self):
		"""
		This builds the model of the Gaussian NB classifier
		"""
		self.clf =  GaussianNB()

	def trainGaussianNB(self,X, Y):
		"""
		Training the Gaussian NB Classifier
		"""
		self.clf.fit(X, Y)

	def validateGaussianNB(self,X, Y):
		"""
		Validate the Gaussian NB Classifier
		"""
		YPred = self.clf.predict(X)
		print accuracy_score(Y, YPred)

	def testGaussianNB(self,X, Y):
		"""
		Test the Gaussian NB Classifier
		"""
		YPred = self.clf.predict(X)
		print accuracy_score(Y, YPred)
