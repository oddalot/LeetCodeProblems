tasks.register("createNewModule") {
    doLast {
        val moduleName = project.property("moduleName")
        if (moduleName !is String) throw RuntimeException("moduleName could not be cast to String")
        mkdir(moduleName)
    }
}