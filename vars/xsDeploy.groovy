#!groovy

@Library(['piper-library-os']) _

def call(Map pipelineParams){
	node(){
		dir(pipelineParams.src){
			sh "/home/jenkinsuser/xsclient/bin/xs api ${pipelineParams.apiendpoint} --skip-ssl-validation"
			sh "/home/jenkinsuser/xsclient/bin/xs login -u ${pipelineParams.username} -p ${pipelineParams.password} -o ${pipelineParams.org} -s ${pipelineParams.space}"
			sh "/home/jenkinsuser/xsclient/bin/xs deploy -f ${pipelineParams.mtaFilePath}"
		}
	}
}