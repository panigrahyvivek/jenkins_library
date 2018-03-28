#!groovy

def call(def system){
	node(){
		echo '12'
		if(system = 'QA'){
			echo '123'
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