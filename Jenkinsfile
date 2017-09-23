node {


   def commit_id
   def dockerImageName = 'anilskp/firewalleventproc'


   stage('Checkout and Maven Build') {
     	docker.image('maven:latest').inside {
	        echo 'Git Checkout..'
	        checkout scm
	        echo 'Build'
	        sh "git rev-parse --short HEAD > .git/commit-id"
            commit_id = readFile('.git/commit-id').trim()
  	        sh "chmod -R 0755 ./"
		writeFile file:'settings.xml', text:"<settings><localRepository>${pwd()}/.m2repo</localRepository></settings>"
	       // sh 'mvn clean package -U'
		sh 'mvn -B -s settings.xml clean install'
        }
    }


   stage('docker build/push') {
     docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
       //def app = docker.build("anilskp/springcassandra", '.')
       def app = docker.build("${dockerImageName}",'.')
       app.push("${commit_id}")
       app.push("latest")
     }
   }

   stage('Cleanup Running Containers') {
    	sh "docker rm -f firewalleventproc || true"
    }
    stage('Deploy') {
    	docker.withRegistry('https://registry.hub.docker.com', "dockerhub") {
			sh "docker run -d --name firewalleventproc  -p 8007:8080  ${dockerImageName}"
		}
    }

}