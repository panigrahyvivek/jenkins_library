#!groovy

def call(String system){
	node(){
		
		if(system == 'QA'){
			timeout(time: 90, unit: 'SECONDS'){
				input "Are you sure you want to promote the changes to ${system}"
			}
		}
		
		if(system == 'PROD'){
			timeout(time: 90, unit: 'SECONDS'){
				input "Are you sure you want to promote the changes to ${system}"
			}
		}
		
		
	}
}