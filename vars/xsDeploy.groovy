#!groovy


def call(Map pipelineParams){
	node(){
		dir(pipelineParams.src){
			
			withCredentials([usernamePassword(credentialsId: 'xsadev', passwordVariable: 'password', usernameVariable: 'username')]) {
			    sh "/home/jenkinsuser/xsclient/bin/xs api ${pipelineParams.apiendpoint} --skip-ssl-validation"
				sh "/home/jenkinsuser/xsclient/bin/xs login -u ${username} -p ${password} -o ${pipelineParams.org} -s ${pipelineParams.space}"
				sh "/home/jenkinsuser/xsclient/bin/xs deploy -f ${pipelineParams.mtaFilePath}"
			}
			
		}
	}
}