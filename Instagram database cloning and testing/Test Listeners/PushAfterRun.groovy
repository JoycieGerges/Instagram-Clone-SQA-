import com.kms.katalon.core.annotation.AfterTestSuite
import java.util.concurrent.*
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.testcase.TestCaseBinding

class PushAfterRun {

	@AfterTestCase
	def afterTestCase() {
		println "Auto pushing results to GitHub..."

		// شغّل السكربت بتاع Git
		def command = ['cmd', '/c', 'C:/Users/lamis/Desktop/auto_push_test_results.bat']
		def process = new ProcessBuilder(command).redirectErrorStream(true).start()

		process.inputStream.eachLine { println it }
		process.waitFor()
	}
}
