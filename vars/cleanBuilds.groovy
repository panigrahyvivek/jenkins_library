def call(String jobName) {
    def job = Jenkins.instance.getItem(jobName)
	job.getBuilds().each { it.delete() }
	job.nextBuildNumber = 1
	job.save()
}

