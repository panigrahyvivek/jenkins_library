#!groovy

def call(){
	echo 'Hello'
	node(){
	    mtaName='generic_xsa'
		sh "/home/jenkinsuser/xsclient/bin/xs api ${XSA_API_ENDPOINT} --skip-ssl-validation"
		sh "/home/jenkinsuser/xsclient/bin/xs login -u ${HANA_XSA_USER} -p ${HANA_XSA_PASSWORD} -o ${ORGANIZATION} -s ${CI_SPACE}"
		sh "/home/jenkinsuser/xsclient/bin/xs deploy -f ${mtaName}.mtar"
	}
}