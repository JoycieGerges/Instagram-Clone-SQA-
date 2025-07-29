import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

// 1. معلومات الاتصال
String dbURL = "jdbc:mysql://localhost:3306/instagram_clone"
String username = "root"
String password = ""

// 2. افتحي الاتصال
Connection connection = DriverManager.getConnection(dbURL, username, password)

// 3. اكتبي SQL Query للتحديث
String sql = "UPDATE users SET email='new_email@example.com' WHERE username='john_doe'"

// 4. نفذي الكويري
Statement statement = connection.createStatement()
statement.executeUpdate(sql)
//
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.nio.file.Files
import java.nio.file.Paths

// المسار الكامل للملف على جهازك
def filePath = "C:/Users/lamis/Desktop/Test/test_results.json"

// تحميل البيانات الحالية
def file = new File(filePath)
def data = []

if (file.exists() && file.text.trim()) {
	data = new JsonSlurper().parseText(file.text)
}

// إضافة نتيجة جديدة
data << ["name": "UpdatetUserTest", "status": "Passed"]

// حفظ الملف
file.text = JsonOutput.prettyPrint(JsonOutput.toJson(data))

// 5. اقفلي الاتصال
connection.close()

println "✅ User Email Updated Successfully!"

