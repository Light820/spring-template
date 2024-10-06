import app.cash.licensee.LicenseeExtension
import app.cash.licensee.LicenseePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LicenseeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(LicenseePlugin::class.java)

            configure<LicenseeExtension> {
                allow("MIT")
                allowUrl("https://spdx.org/licenses/MIT.txt")
                allow("Apache-2.0")
                allowUrl("https://repository.jboss.org/licenses/apache-2.0.txt")
                allow("EPL-1.0")
                allow("LGPL-2.1-only")
                allowUrl("https://www.mozilla.org/en-US/MPL/2.0/")
                allowUrl("https://opensource.org/licenses/eclipse-1.0.php")
                allowUrl("http://www.eclipse.org/legal/epl-2.0")
                allowUrl("https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.txt")
                allowUrl("http://www.eclipse.org/org/documents/edl-v10.php")
                allowUrl("https://www.eclipse.org/legal/epl-v20.html")
                allowUrl("https://jdbc.postgresql.org/about/license.html")
                allowUrl("https://www.eclipse.org/legal/epl-v20.htm")
                allowUrl("http://www.antlr.org/license.html")
            }
        }
    }
}
