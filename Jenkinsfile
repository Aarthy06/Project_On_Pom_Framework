pipeline{
agent any
stages{
stage('SCM Checkout')
  {
       git url : 'https://github.com/Aarthy06/Project_On_Pom_Framework'
   }
stage('Compile-Package')
{
  def mvnhome = tool = name:'maven_3.6.2' ,type: 'maven' 
  sh "${mvnhome}/bin/mvn package"
}
}
}
