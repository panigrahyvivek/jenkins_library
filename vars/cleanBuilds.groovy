def call(String jobname) {
    def job = Jenkins.instance.getItem(jobName)
	job.getBuilds().each { it.delete() }
	job.nextBuildNumber = 1
	job.save()
}