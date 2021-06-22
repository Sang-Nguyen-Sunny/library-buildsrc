interface BuildType {

    companion object {
        const val DEBUG = "debug"
        const val STAGING = "staging"
        const val RELEASE = "release"
    }

    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val shrinkResources: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isTestCoverageEnabled = true
    override val shrinkResources = false
    const val versionNameSuffix = "-DEBUG"
}

object BuildTypeStaging : BuildType {
    override val isMinifyEnabled = false
    override val isTestCoverageEnabled = true
    override val shrinkResources = false
    const val versionNameSuffix = "-STAGING"
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
    override val shrinkResources = false
    override val isTestCoverageEnabled = false
    const val versionNameSuffix = "-RELEASE"
}