node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/Aarthy06/Project_On_Pom_Framework'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'maven_3.6.2'
   }
   stage('Build') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
         if (isUnix()) {
            sh '"$MVN_HOME/bin/mvn" package'
         } else {
            bat(/"%MVN_HOME%\bin\mvn" package/)
         }
      }
   }
   stage('Result Report'){
   publishHTML(target:[allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       includes: '**/*html', 
                       keepAll: true, 
                       reportDir: 'test-output', 
                       reportFiles: 'ExtentReposhot.html', 
                       reportName: 'HTML Report', 
                       reportTitles: ''])
   } 
   
   stage('Email Notification'){
      mail bcc: '', body: '', cc: '', from: '', 
         replyTo: 'sonugadwe06@gmail.com', 
         subject: 'This is Pipeline Job Build Status', 
         to: 'arthymane27@gamil.com'
      
      
  
   } 
   
   
   
}
