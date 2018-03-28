#!groovy

def call(Map pipelineParams){
	echo 'Hello'
	node(){
	    mtaName='generic_xsa'
		sh "/home/jenkinsuser/xsclient/bin/xs api ${pipelineParams.XSA_API_ENDPOINT} --skip-ssl-validation"
		sh "/home/jenkinsuser/xsclient/bin/xs login -u ${pipelineParams.HANA_XSA_USER} -p ${pipelineParams.HANA_XSA_PASSWORD} -o ${pipelineParams.ORGANIZATION} -s ${pipelineParams.CI_SPACE}"
		sh "/home/jenkinsuser/xsclient/bin/xs deploy -f ${mtaName}.mtar"
	}
}