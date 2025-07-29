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

import java.sql.*

String dbURL = "jdbc:mysql://localhost:3306/instagram_clone"
String username = "root"
String password = ""

Connection connection = DriverManager.getConnection(dbURL, username, password)

// 1. أضف كومنت
String insertCommentSQL = "INSERT INTO comments (user_id, post_id, comment_text, created_at) VALUES (1, 1, 'Great photo!', NOW())"
Statement statement = connection.createStatement()
statement.executeUpdate(insertCommentSQL)

// 2. تحقق أن الكومنت موجود
String selectSQL = "SELECT * FROM comments WHERE user_id = 1 AND post_id = 1 AND comment_text = 'Great photo!'"
ResultSet resultSet = statement.executeQuery(selectSQL)

if (resultSet.next()) {
	println("✅ Comment inserted successfully!")
} else {
	println("❌ Comment insertion failed!")
}

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
data << ["name": "Add a comment", "status": "Passed"]

// حفظ الملف
file.text = JsonOutput.prettyPrint(JsonOutput.toJson(data))



connection.close()
