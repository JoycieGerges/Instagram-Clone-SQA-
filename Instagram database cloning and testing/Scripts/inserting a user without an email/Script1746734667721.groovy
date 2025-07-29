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
//
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.nio.file.Files
import java.nio.file.Paths
def filePath = "C:/Users/lamis/Desktop/Test/test_results.json"

// تحميل البيانات الحالية
def file = new File(filePath)
def data = []

if (file.exists() && file.text.trim()) {
	data = new JsonSlurper().parseText(file.text)
}

// إضافة نتيجة جديدة
data << ["name": "Add a user without a email", "status": "Faild"]

// حفظ الملف
file.text = JsonOutput.prettyPrint(JsonOutput.toJson(data))
// Test Case: Insert User Without Email
'Start the test case'
def username = 'test_user'
def email = ''
def password = 'test123'

'Connect to the database'
WebUI.openBrowser('')

'Insert user data without email'
def insertUserQuery = "INSERT INTO users (username, password) VALUES ('${username}', '${password}')"
def result = executeSQL(insertUserQuery)

'Check the result of the query'
assert result == "Error: Email is required"
