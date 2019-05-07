pipeline{
		agent any 

		stages{
			stage('Complile stage') {
				steps{
					withMaven(maven : 'maven 3_3_9'){
					sh 'mvn clean compile'
						}
					}
				}
				
			stage('Testing stage') {
			steps{
					withMaven(maven : 'maven 3_3_9'){
					sh 'mvn test'
						}
					}
				}
				
					
			stage('Deployment stage') {
			steps{
					withMaven(maven : 'maven 3_3_9'){
					sh 'mvn deploy'
						}
					}
				}
			} 	
	}