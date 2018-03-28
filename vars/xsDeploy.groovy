#!groovy

def call(Map pipelineParams){
	node(){
		dir(pipelineParams.src){
			
			withCredentials([usernamePassword(credentialsId: pipelineParams.credentialsId, passwordVariable: 'password', usernameVariable: 'username')]) {
			    sh "${pipelineParams.xsHome}/xs api ${pipelineParams.apiendpoint} --skip-ssl-validation"
				sh "${pipelineParams.xsHome}/xs login -u ${username} -p ${password} -o ${pipelineParams.org} -s ${pipelineParams.space}"
				sh "${pipelineParams.xsHome}/xs deploy -f ${pipelineParams.mtaFilePath}"
				sh "${pipelineParams.xsHome}/xs logout"
			}
			
		}
	}
}