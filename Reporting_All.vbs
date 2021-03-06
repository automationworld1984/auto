Function DateTime()
	tempdate= date  
	splitdate=split(tempdate,"/")
	Adddate=splitdate(0)&"_"&splitdate(1)&"_"&splitdate(2)
	tempTime=time
	splitTime=split(tempTime," ")
	splitTime1=split(splitTime(0),":")
	DateAddTime=Adddate&"_"&splitTime1(0)&"_"&splitTime1(1)&"_"&splitTime1(2)&"_"&splitTime(1)
	DateTime=DateAddTime
End Function

Function GetStartPos_NoofSteps_backup2(SheetName,TestCaseName,TestPlanPath)
	On error resume next
	Set myxl1 = createobject("excel.application")
	Set objWorkbook =myxl1.Workbooks.Add
	Set objWorkbook = myxl1.Workbooks.Open(TestPlanPath)
	Set objWorksheet = myxl1.ActiveWorkbook.Worksheets(SheetName)
	r=objworksheet.usedrange.rows.count
	Set rng= myxl1.ActiveWorkbook.Worksheets(SheetName).range("A1:A" & r)
	Set ofind=rng.find(TestCaseName)
	If err.number=0 and ofind_mergerange<>empty Then
		ofind_mergerange=ofind.mergearea.address
	else
		for each c in rng.rows
			If c.MergeCells Then
				ofind_mergerange = c.MergeArea.Address
				tempval=c.value
				If strcomp(tempval,TestCaseName)=0 Then
					Exit for
				End If
			End If
		Next
	End If
	Set reg=new regexp
	reg.pattern="\d+"
	reg.global=true
	Set matches=reg.execute(ofind_mergerange)
	For each match in matches
		match=temp&" "&match
		temp=match
	Next
	myxl1.ActiveWorkbook.Save
	myxl1.Application.Quit
	Set myxl1=nothing
	GetStartPos_NoofSteps=split(temp," ")
End Function

Function GetStartPos_NoofSteps_backup(SheetName,TestCaseName,TestPlanPath)
	Set myxl1 = createobject("excel.application")
	Set objWorkbook =myxl1.Workbooks.Add
	Set objWorkbook = myxl1.Workbooks.Open(TestPlanPath)
	Set objWorksheet = myxl1.ActiveWorkbook.Worksheets(SheetName)
	r=objworksheet.usedrange.rows.count
	Set ofind=objWorksheet.range("A1:A" & r).find(TestCaseName)
	ofind_rownum=ofind.row
	ofind_mergerange=ofind.mergearea.address
	Set reg=new regexp
	reg.pattern="\d+"
	reg.global=true
	Set matches=reg.execute(ofind_mergerange)
	For each match in matches
		match=temp&" "&match
		temp=match
	Next
	myxl1.ActiveWorkbook.Save
	myxl1.Application.Quit
	Set myxl1=nothing
	GetStartPos_NoofSteps=split(temp," ")
End Function

Function GetStartPos_NoofSteps(SheetName,TestCaseName,TestPlanPath)
	Set myxl1 = createobject("excel.application")
	Set objWorkbook =myxl1.Workbooks.Add
	Set objWorkbook = myxl1.Workbooks.Open(TestPlanPath)
	Set objWorksheet = myxl1.ActiveWorkbook.Worksheets(SheetName)
	r=objworksheet.usedrange.rows.count
	Set rng= myxl1.ActiveWorkbook.Worksheets(SheetName).range("A1:A" & r)
	Set ofind=rng.find(TestCaseName)
	ofind_mergerange=ofind.mergearea.address
'	for each c in rng.rows
'		If c.MergeCells Then
'			ofind_mergerange = c.MergeArea.Address
'			tempval=c.value
'			If strcomp(tempval,TestCaseName)=0 Then
'				Exit for
'			End If
'		End If
'	Next
	Set reg=new regexp
	reg.pattern="\d+"
	reg.global=true
	Set matches=reg.execute(ofind_mergerange)
	For each match in matches
		match=temp&" "&match
		temp=match
	Next
	myxl1.ActiveWorkbook.Save
	myxl1.Application.Quit
	Set myxl1=nothing
	GetStartPos_NoofSteps=split(temp," ")
End Function

Function UpdateTestPlan(SheetName,StartPosition,Actual,Status,TestPlanPath)
	Set myxl1 = createobject("excel.application")
	'Set objWorkbook =myxl1.Workbooks.Add
	Set objWorkbook = myxl1.Workbooks.Open(TestPlanPath)
	Set objWorksheet = myxl1.ActiveWorkbook.Worksheets(SheetName)
	numberofSheet=objWorkbook.Worksheets.Count
	For intsheet1 = 1 To numberOfSheet
		tempsheetname=objWorkbook.Worksheets(intsheet1).name		
		If cstr(ucase(trim(tempsheetname)))=cstr(ucase(trim(SheetName)))  Then
			Exit for
		End if
	next
	objWorksheet.cells(StartPosition,5).value=Actual
	objWorksheet.cells(StartPosition,6).value=Status
	myxl1.ActiveWorkbook.Save
	myxl1.Application.Quit
	Set myxl1=nothing
End Function

Function CreateReportFile_backup(FileNamewithPath)
	Set myxl1 = createobject("excel.application")
	Set fso = createobject("scripting.filesystemobject")
	If NOT(fso.FolderExists(fso.GetParentFolderName(FileNamewithPath))) Then
	    fso.CreateFolder(fso.GetParentFolderName(FileNamewithPath))
	End If
	If fso.FileExists(FileNamewithPath) Then
		filename_src=fso.GetFileName(FileNamewithPath)
		filename_src=split(filename_src,".")
		FilePath_src=fso.GetParentFolderName(FileNamewithPath)
		filename_dst=filename_src(0)&"_"&DateTime()&"."&filename_src(1)
		FileNamewithPath_dst=FilePath_src&"\"&filename_dst
		fso.CopyFile FileNamewithPath,FileNamewithPath_dst
		Set objWorkbook = myxl1.Workbooks.Open(FileNamewithPath)
 		numberofSheet=objWorkbook.Worksheets.Count
		For intsheet1 = 1 To numberOfSheet
			objWorkbook.Worksheets(intsheet1).Select
			objWorkbook.Worksheets(intsheet1).name="Sheet"&intsheet1
			objWorkbook.Worksheets(intsheet1).usedrange.rows.clearcontents
			objWorkbook.Worksheets(intsheet1).usedrange.columns.delete
			objWorkbook.Worksheets(intsheet1).usedrange.rows.delete
		Next
		myxl1.ActiveWorkbook.Save
	else
		Set objWorkbook =myxl1.Workbooks.Add
		objWorkbook.SaveAs(FileNamewithPath)
	End If
	Set objWorkbook=nothing
	myxl1.Quit
	Set myxl1 = Nothing
End Function

'****************************************************************************************************************************************
'Script Name				: CreateReportFile
'Description 				: This is the function to create a file; in case filename exists, it deletes a file and create copy of existing file
'Created By 				: K Saurabh 
'Creation start Date		: Nov 28, 2014
'Updated By 				: 
'Updated Date 				: 
'****************************************************************************************************************************************
Function CreateReportFile(FileNamewithPath)
	
	Set myxl1 = createobject("excel.application")
	Set fso = createobject("scripting.filesystemobject")
	If NOT(fso.FolderExists(fso.GetParentFolderName(FileNamewithPath))) Then
	    fso.CreateFolder(fso.GetParentFolderName(FileNamewithPath))
	End If
	If fso.FileExists(FileNamewithPath) Then
		filename_src=fso.GetFileName(FileNamewithPath)
		filename_src=split(filename_src,".")
		FilePath_src=fso.GetParentFolderName(FileNamewithPath)
		filename_dst=filename_src(0)&"_"&DateTime()&"."&filename_src(1)
		FileNamewithPath_dst=FilePath_src&"\"&filename_dst
		fso.CopyFile FileNamewithPath,FileNamewithPath_dst
		fso.DeleteFile(FileNamewithPath)
		Set objWorkbook =myxl1.Workbooks.Add
		objWorkbook.SaveAs(FileNamewithPath)
	else
		Set objWorkbook =myxl1.Workbooks.Add
		objWorkbook.SaveAs(FileNamewithPath)
	End If
	Set objWorkbook=nothing
	myxl1.Quit
	Set myxl1 = Nothing
End Function

'Function WriteStepInWorkSheet(SheetName,StartPosition,NumberofSteps,Actual,Status,FileNamewithPath)
Function WriteStepInWorkSheet(TestCaseName,TestPlanSheetName,StartPosition,NumberofSteps,FileNamewithPath)
	Set myxl1 = createobject("excel.application")
	Set objWorkbook = myxl1.Workbooks.Open(FileNamewithPath)
	intsheet1=3
		
	objWorkbook.Worksheets(intsheet1).name="Execution Details"
    
    
    objWorkbook.Worksheets(intsheet1).Select
	objWorkbook.Worksheets(intsheet1).Columns("A:A").ColumnWidth = 20
	objWorkbook.Worksheets(intsheet1).Columns("B:B").ColumnWidth = 15
	objWorkbook.Worksheets(intsheet1).Columns("C:E").ColumnWidth = 40
'	objWorkbook.Worksheets(intsheet1).Columns("C:C").ColumnWidth = 40
'	objWorkbook.Worksheets(intsheet1).Columns("D:D").ColumnWidth = 40
	objWorkbook.Worksheets(intsheet1).Columns("F:F").ColumnWidth = 15
	objWorkbook.Worksheets(intsheet1).Columns("C:E").WrapText = True		
    objWorkbook.Worksheets(intsheet1).Range("A1").Value = "Test Case Name"
	objWorkbook.Worksheets(intsheet1).Range("B1").Value = "Step No"
	objWorkbook.Worksheets(intsheet1).Range("C1").Value = "Description"
	objWorkbook.Worksheets(intsheet1).Range("D1").Value = "Expected Result"
	objWorkbook.Worksheets(intsheet1).Range("E1").Value = "Actual Result"
	objWorkbook.Worksheets(intsheet1).Range("F1").Value = "Status"
	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Interior.ColorIndex = 53
	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Font.ColorIndex = 19
	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Font.Bold = True			
	
	'Set the Borders for the Result Header
'	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Borders(1).LineStyle = 1
'	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Borders(2).LineStyle = 1
'	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Borders(3).LineStyle = 1
'	objWorkbook.Worksheets(intsheet1).Range("A1:F1").Borders(4).LineStyle = 1		
	
	getRowNumber=objWorkbook.Worksheets(intsheet1).UsedRange.Rows.count
	
	objWorkbook.Worksheets(intsheet1).Range("A"&(getRowNumber+1)&":A"&(getRowNumber+NumberofSteps)).merge
'	myxl1.ActiveWorkbook.worksheets(intsheet1).range(cells(getRowNumber+1,1),cells(NumberofSteps-1,1)).merge
	'myxl1.ActiveWorkbook.Worksheets(intsheet1).range(cells(getRowNumber+1,1),cells(NumberofSteps-1,1)).merge
	'activesheet.range(cells(getRowNumber+1,1),cells(NumberofSteps-1,1)).value=SheetName
'	objWorkbook.Worksheets(intsheet1).Cells(getRowNumber+1,1).Value=SheetName
	objWorkbook.Worksheets(intsheet1).Range("A"&(getRowNumber+1)&":A"&(getRowNumber+NumberofSteps)).value=TestCaseName
	'To_selection= objWorkbook.Worksheets(intsheet1).Range("A"&(getRowNumber+1)&":A"&(getRowNumber+NumberofSteps)).value
	
	' HTML REPORTING BEGIN <SAFE> : 
	Call HTMLRep_Insert_Section(TestCaseName)
	' HTML REPORTING END <SAFE> : 
	Result= FetchDatafromTestPlan(TestPlanSheetName,StartPosition,NumberofSteps)
	For each j in Result
		getRowNumber=getRowNumber+1
		StepDetails=split(j,"^")
		StepNumber=StepDetails(0)
		StepDescription=StepDetails(1)
		Expected=StepDetails(2)
		Actual=StepDetails(3)
		Status=StepDetails(4)
		objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,2).Value=StepNumber
		objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,3).Value=StepDescription
		objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,4).Value=Expected
		'TBD either from Action or fetch runtime from function
		objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,5).Value=Actual
		objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,6).Value=Status
		If ucase(Status)=ucase("fail") Then
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,2).Interior.Color=RGB(1000,0,0)
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,3).Interior.Color=RGB(1000,0,0)
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,4).Interior.Color=RGB(1000,0,0)
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,5).Interior.Color=RGB(1000,0,0)
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,6).Interior.Color=RGB(1000,0,0)
			indexflag="false"
		End If	
		If ucase(Status)=ucase("not completed") or ucase(Status)=ucase("no run") Then
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,2).Interior.Color=vbYellow
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,3).Interior.Color=vbYellow
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,4).Interior.Color=vbYellow
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,5).Interior.Color=vbYellow
			objWorkbook.Worksheets(intsheet1).Cells(getRowNumber,6).Interior.Color=vbYellow
			indexflag="false"
		End If	
		' HTML REPORTING BEGIN <SAFE> : 
		Call HTMLRep_Insert_Result(TestCaseName, StepNumber, StepDescription, Expected, Actual, Status)
		' HTML REPORTING END <SAFE> : 
	Next
	
	objWorkbook.Worksheets(intsheet1).usedrange.rows.Borders(1).LineStyle = 1
	objWorkbook.Worksheets(intsheet1).usedrange.rows.Borders(2).LineStyle = 1
	objWorkbook.Worksheets(intsheet1).usedrange.rows.Borders(3).LineStyle = 1
	objWorkbook.Worksheets(intsheet1).usedrange.rows.Borders(4).LineStyle = 1
	
	intsheet2=2
	objWorkbook.Worksheets(intsheet2).name="Index"
	objWorkbook.Worksheets(intsheet2).Select
	objWorkbook.Worksheets(intsheet2).Columns("A:A").ColumnWidth = 20
	objWorkbook.Worksheets(intsheet2).Columns("B:B").ColumnWidth = 15
	objWorkbook.Worksheets(intsheet2).Columns("C:C").ColumnWidth = 15
	objWorkbook.Worksheets(intsheet2).Columns("A:C").WrapText = True
	objWorkbook.Worksheets(intsheet2).Range("A1").Value = "Test Case Name"
	objWorkbook.Worksheets(intsheet2).Range("B1").Value = "Status"
	objWorkbook.Worksheets(intsheet2).Range("C1").Value = "Test Duration"
	objWorkbook.Worksheets(intsheet2).Range("D:D").NumberFormat = "dd-mmm-yyyy hh:mm:ss"
	objWorkbook.Worksheets(intsheet2).Range("E:E").NumberFormat = "dd-mmm-yyyy hh:mm:ss"
	objWorkbook.Worksheets(intsheet2).Range("A1:C1").Interior.ColorIndex = 53
	objWorkbook.Worksheets(intsheet2).Range("A1:C1").Font.ColorIndex = 19
	objWorkbook.Worksheets(intsheet2).Range("A1:C1").Font.Bold = True
	objWorkbook.Worksheets(intsheet2).Range("A1:C1").Borders(1).LineStyle = 1
	
	getRowNumber2=objWorkbook.Worksheets(intsheet2).UsedRange.Rows.count
	objWorkbook.Worksheets(intsheet2).Cells(getRowNumber2+1,1).select
	objWorkbook.Worksheets(intsheet2).Cells(getRowNumber2+1,1).Value=TestCaseName
	myxl1.ActiveWorkbook.Worksheets(intsheet2).Hyperlinks.add myxl1.Selection,FileNamewithPath,"'Execution Details'!A"&getRowNumber
	If indexflag="false" Then
		objWorkbook.Worksheets(intsheet2).Cells(getRowNumber2+1,2).Value="Fail"
		objWorkbook.Worksheets(intsheet2).Cells(getRowNumber2+1,2).Interior.Color=RGB(1000,0,0)
	else
		objWorkbook.Worksheets(intsheet2).Cells(getRowNumber2+1,2).Value="Pass"
		objWorkbook.Worksheets(intsheet2).Cells(getRowNumber2+1,2).Interior.Color=RGB(0,250,0)
	End If
	objWorkbook.Worksheets(intsheet2).usedrange.rows.Borders(1).LineStyle = 1
	objWorkbook.Worksheets(intsheet2).usedrange.rows.Borders(2).LineStyle = 1
	objWorkbook.Worksheets(intsheet2).usedrange.rows.Borders(3).LineStyle = 1
	objWorkbook.Worksheets(intsheet2).usedrange.rows.Borders(4).LineStyle = 1
	myxl1.ActiveWorkbook.Save
	myxl1.Application.Quit
	Set myxl1=nothing
	
	

End Function

'#################################################################################
' About : Writing into INDEX file about each test case
'#################################################################################~~
Function FnHTML_Report_Index(sHTMLFile2, xlFileNamewithPath)
	' HTML Reporting BEGIN for INDEX file (Global File variable: HTML_REPORT_FILE3)
	Dim var_objReport 'File Object
    Dim var_objFS  'File System Object
    Set var_objFS = CreateObject("Scripting.FileSystemObject")
    Set var_objReport = var_objFS.OpenTextFile(sHTMLFile2, 2, True)
    var_objReport.Write "<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>"
    var_objReport.Close
    Set var_objReport = var_objFS.OpenTextFile(sHTMLFile2, 8, True)
    var_objReport.Write "<TR><TD COLSPAN=6 BGCOLOR=#FAFAFA><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><U> INDEX </U></B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=4><TD BGCOLOR=#EEF0A2 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B> Module </B></FONT></TD><TD BGCOLOR=#EEF0A2 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Name </B></FONT></TD><TD BGCOLOR=#EEF0A2 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B> Status </B></FONT></TD><TD BGCOLOR=#EEF0A2 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B> Test Duration </B></FONT></TD></TR>"
    'var_objReport.Write "<TR COLS=3><TD BGCOLOR=#D9D9CF WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Start Time: </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & Date & "</B></FONT></TD></TR>"
    
    
   	' HTML Reporting END for INDEX file (Temp 2)
	Set myxl12 = createobject("excel.application")
	Set objWorkbook12 = myxl12.Workbooks.Open(xlFileNamewithPath)
	objWorkbook12.Worksheets("Index").Select
	getRowNumber12=objWorkbook12.Worksheets("Index").UsedRange.Rows.count
	For i12=2 to getRowNumber12
		vModule_Name = objWorkbook12.Worksheets("Index").Cells(i12,6).Value
		vTC_Name = objWorkbook12.Worksheets("Index").Cells(i12,1).Value
		vTC_Status = objWorkbook12.Worksheets("Index").Cells(i12,2).Value
		vTC_ExecTime = FormatNumber((objWorkbook12.Worksheets("Index").Cells(i12,3).Value)*24*60, 2)
		'vTC_ExecTime = objWorkbook12.Worksheets("Index").Cells(i12,3).Value
		vHREF_Name = chr(34) & "#" & Trim(Ucase(vTC_Name)) & chr(34)
		If UCASE(vTC_Status) <> "PASS" Then
			'var_objReport.Write "<TR COLS=3><TD BGCOLOR=#D9FFFD WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2> <A HREF =" & vHREF_Name & ">" & vTC_Name & "</A></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=RED SIZE=2><B> " & vTC_Status & "</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vTC_ExecTime & "</B></FONT></TD></TR>"
			var_objReport.Write "<TR COLS=4><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vModule_Name & "</B></FONT></TD><TD BGCOLOR=#D9FFFD WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2> <A HREF =" & vHREF_Name & ">" & vTC_Name & "</A></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=RED SIZE=2><B> " & vTC_Status & "</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vTC_ExecTime & "</B></FONT></TD></TR>"
		Else	
			'var_objReport.Write "<TR COLS=3><TD BGCOLOR=#D9FFFD WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2> <A HREF =" & vHREF_Name & ">" & vTC_Name & "</A></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B> " & vTC_Status & "</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vTC_ExecTime & "</B></FONT></TD></TR>"
			var_objReport.Write "<TR COLS=4><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vModule_Name & "</B></FONT></TD><TD BGCOLOR=#D9FFFD WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2> <A HREF =" & vHREF_Name & ">" & vTC_Name & "</A></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B> " & vTC_Status & "</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vTC_ExecTime & "</B></FONT></TD></TR>"
		End If
		
	Next
	var_objReport.Write "</TABLE></BODY></HTML>"
    var_objReport.Close
    Set var_objFS = Nothing
    Set var_objReport = Nothing
	myxl12.Quit
	Set objWorkbook12=nothing
	Set myxl12=nothing
End Function

'#################################################################################
' About : Generating final HTML file after merging all files
'#################################################################################~~
Function FnGenerateOutputHTMLFile(sOutputFileToWrite)
	Dim var_objReport 'File Object
    Dim var_objFS  'File System Object
    Set var_objFS = CreateObject("Scripting.FileSystemObject")
    If NOT(var_objFS.FolderExists(var_objFS.GetParentFolderName(sOutputFileToWrite))) Then
	    var_objFS.CreateFolder(var_objFS.GetParentFolderName(sOutputFileToWrite))
	End If
	
    Set var_objReport = var_objFS.OpenTextFile(sOutputFileToWrite, 2, True)
    
    var_objReport.Write "<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='" & IMG_LOGO_FILE & "'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=2><B>&nbsp;Test Execution for Release: " & TEST_RELEASE & ", on " & Date & "," & Time & " on Machine " & Environment.Value("LocalHostName") & "|| Environment:  " & TEST_ENV & "</B></FONT></TD></TR></TABLE>"
    var_objReport.Write "<br></br>"
    var_objReport.Close
    Set var_objReport = var_objFS.OpenTextFile(HTML_REPORT_FILE2, 1, True)
	strText =  var_objReport.ReadAll  
	var_objReport.Close  
	Set var_objReport = var_objFS.OpenTextFile(sOutputFileToWrite, 8, True)
	var_objReport.WriteLine  StrText 
	var_objReport.Write "<br></br>"
	var_objReport.Close 
	strText = ""
	Set var_objReport = var_objFS.OpenTextFile(HTML_REPORT_FILE3, 1, True)
	strText =  var_objReport.ReadAll  
	var_objReport.Close  
	Set var_objReport = var_objFS.OpenTextFile(sOutputFileToWrite, 8, True)
	var_objReport.WriteLine  StrText 
	var_objReport.Write "<br></br>"
	var_objReport.Close 
	
	Set var_objReport = var_objFS.OpenTextFile(HTML_REPORT_FILE1, 1, True)
	strText =  var_objReport.ReadAll  
	var_objReport.Close  
	Set var_objReport = var_objFS.OpenTextFile(sOutputFileToWrite, 8, True)
	var_objReport.WriteLine  StrText 
	var_objReport.Write "</TABLE></BODY></HTML>"
	var_objReport.Close 
End Function

Function FetchDatafromTestPlan(TestPlanSheetName,StartPosition,NumberofSteps)
	Set myxl1 = createobject("excel.application")
	myxl1.Workbooks.Add
'	TestPlanPath="C:\MVAutomation\Report\TestPlan.xls"
	Set objWorkbook = myxl1.Workbooks.Open(TestPlanPath)
	Set objWorkSheet=myxl1.ActiveWorkbook.Worksheets(TestPlanSheetName)
	Dim str()
	ReDim str(NumberofSteps-1)
	For i=0 to NumberofSteps-1					
'		If i=1 Then
'			str=objWorkSheet.cells(StartPosition,2)&"_"&objWorkSheet.cells(StartPosition,3)&"_"&objWorkSheet.cells(StartPosition,4)&"_"&objWorkSheet.cells(StartPosition,5)&"_"&objWorkSheet.cells(StartPosition,6)
			str(i)=objWorkSheet.cells(StartPosition,2)&"^"&objWorkSheet.cells(StartPosition,3)&"^"&objWorkSheet.cells(StartPosition,4)&"^"&objWorkSheet.cells(StartPosition,5)&"^"&objWorkSheet.cells(StartPosition,6)
'		else
'			str=str&","&objWorkSheet.cells(StartPosition,2)&"_"&objWorkSheet.cells(StartPosition,3)&"_"&objWorkSheet.cells(StartPosition,4)&"_"&objWorkSheet.cells(StartPosition,5)&"_"&objWorkSheet.cells(StartPosition,6)
'		End If
		StartPosition=StartPosition+1
	Next
'	FetchDatafromTestPlan=split(str,",")	
	FetchDatafromTestPlan=str
	myxl1.Application.Quit
	Set myxl1=nothing
End Function

'****************************************************************************************************************************************
'Script Name				: createSummaryReport
'Description 				: This is the function to create summary report
'Created By 				: K Saurabh 
'Creation start Date		: Nov 06, 2014
'Updated By 				: K Saurabh 
'Updated Date 				: Nov 28,2014
'****************************************************************************************************************************************
Function createSummaryReport(FileNamewithPath)
	SummaryDetail=Split(SummaryDetails," ")
	Set myxl2 = createobject("excel.application")
	Set objWorkbook1 = myxl2.Workbooks.Open(FileNamewithPath)
	intsheet=2
	objWorkbook1.Worksheets(intsheet).Select
	Set objworksheet=myxl2.ActiveWorkbook.Worksheets(intsheet)
	getRowNumber=objWorkbook1.Worksheets(intsheet).UsedRange.Rows.count
	vPass=0
	vFail=0
	vNotComp=0
	For i=2 to getRowNumber
		If objworksheet.cells(i,2).value="Pass" Then
			vPass=vPass+1
		ElseIf objworksheet.cells(i,2).value="Fail" Then
			vFail=vFail+1
		else
			vNotComp=vNotComp+1
		End If		
	Next
'	creating summary report sheet 
	SummarySheetName=1
	objWorkbook1.Worksheets(SummarySheetName).Name="Summary Report"
	objWorkbook1.Worksheets(SummarySheetName).Select
	objWorkbook1.Worksheets(SummarySheetName).Range("B1").Value ="Test Results"
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C1").Merge
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C1").Interior.ColorIndex = 53
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C1").Font.ColorIndex = 19
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C1").Font.Bold = True
	'Set the Date and time of Execution
	objWorkbook1.Worksheets(SummarySheetName).Range("B2").Value = "Test Date: "
	objWorkbook1.Worksheets(SummarySheetName).Range("B3").Value = "Test Start Time: "
	objWorkbook1.Worksheets(SummarySheetName).Range("B4").Value = "Test End Time: "
	objWorkbook1.Worksheets(SummarySheetName).Range("B5").Value = "Test Duration: "
	objWorkbook1.Worksheets(SummarySheetName).Range("C2").Value = Date
	objWorkbook1.Worksheets(SummarySheetName).Range("C2").NumberFormat = "dd-mmm-yyyy"
	objWorkbook1.Worksheets(SummarySheetName).Range("C3").Value = Environment("T_Start")
	objWorkbook1.Worksheets(SummarySheetName).Range("C3").NumberFormat = "dd-mmm-yyyy hh:mm:ss"	
	objWorkbook1.Worksheets(SummarySheetName).Range("C4").Value = Now
	objWorkbook1.Worksheets(SummarySheetName).Range("C4").NumberFormat = "dd-mmm-yyyy hh:mm:ss"
	'calculating test batch execution time	
	objWorkbook1.Worksheets(SummarySheetName).Range("C5").Value = "=R[-1]C-R[-2]C"
	
	'vDura = FormatNumber((objWorkbook1.Worksheets(SummarySheetName).Range("C5").Value)*1000*100/60, 3)
	vDura = DateDiff("n", Environment("T_Start"), Now)
	objWorkbook1.Worksheets(SummarySheetName).Range("C5").NumberFormat = "[h]:mm:ss;@"
	objWorkbook1.Worksheets(SummarySheetName).Range("B2:B5").Font.Bold = True
	objWorkbook1.Worksheets(SummarySheetName).Range("B2:B5").Interior.ColorIndex = 19
	objWorkbook1.Worksheets(SummarySheetName).Range("C2:C5").Interior.ColorIndex = 19
	objWorkbook1.Worksheets(SummarySheetName).Range("B6").Value = "Total No Scripts executed"
	objWorkbook1.Worksheets(SummarySheetName).Range("B7").Value = "Passed"
	objWorkbook1.Worksheets(SummarySheetName).Range("B8").Value = "Failed"
'	objWorkbook1.Worksheets(SummarySheetName).Range("B9").Value = "No Run"
	objWorkbook1.Worksheets(SummarySheetName).Range("B9").Value = "Not Completed"
	objWorkbook1.Worksheets(SummarySheetName).Range("C6").Value=getRowNumber-1
	objWorkbook1.Worksheets(SummarySheetName).Range("C7").Value=vPass
	objWorkbook1.Worksheets(SummarySheetName).Range("C8").Value=vFail
'	objWorkbook1.Worksheets(SummarySheetName).Range("C9").Value=SummaryDetail(3)
	objWorkbook1.Worksheets(SummarySheetName).Range("C9").Value=vNotComp	
	objWorkbook1.Worksheets(SummarySheetName).Range("B6:B9").Interior.ColorIndex = 15
	objWorkbook1.Worksheets(SummarySheetName).Range("C6:C9").Interior.ColorIndex = 15
	objWorkbook1.Worksheets(SummarySheetName).Range("B6:B9").Font.Bold = True	
	'Set the Borders for the Result Summery
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C9").Borders(1).LineStyle = 1
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C9").Borders(2).LineStyle = 1
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C9").Borders(3).LineStyle = 1
	objWorkbook1.Worksheets(SummarySheetName).Range("B1:C9").Borders(4).LineStyle = 1	
	objWorkbook1.Worksheets(SummarySheetName).Columns("B:C").Autofit
	
	intsheet1=2
	objWorkbook1.Worksheets(intsheet1).select
	objWorkbook1.Worksheets(intsheet1).usedrange.rows.Borders(1).LineStyle = 1
	objWorkbook1.Worksheets(intsheet1).usedrange.rows.Borders(2).LineStyle = 1
	objWorkbook1.Worksheets(intsheet1).usedrange.rows.Borders(3).LineStyle = 1
	objWorkbook1.Worksheets(intsheet1).usedrange.rows.Borders(4).LineStyle = 1
	
	intsheet2=3
	objWorkbook1.Worksheets(intsheet2).select
	objWorkbook1.Worksheets(intsheet2).usedrange.rows.Borders(1).LineStyle = 1
	objWorkbook1.Worksheets(intsheet2).usedrange.rows.Borders(2).LineStyle = 1
	objWorkbook1.Worksheets(intsheet2).usedrange.rows.Borders(3).LineStyle = 1
	objWorkbook1.Worksheets(intsheet2).usedrange.rows.Borders(4).LineStyle = 1
	
	objWorkbook1.Worksheets(SummarySheetName).select
	myxl2.ActiveWorkbook.Save
	myxl2.Application.Quit
	Set myxl2=nothing
	
	' HTML Reporting BEGIN for Summary file (Global File variable: HTML_REPORT_FILE2)
	Dim var_objReport 'File Object
    Dim var_objFS  'File System Object
    Set var_objFS = CreateObject("Scripting.FileSystemObject")
    Set var_objReport = var_objFS.OpenTextFile(HTML_REPORT_FILE2, 2, True)
    var_objReport.Write "<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>"
    var_objReport.Close
    Set var_objReport = var_objFS.OpenTextFile(HTML_REPORT_FILE2, 8, True)
    var_objReport.Write "<TR><TD COLSPAN=6 BGCOLOR=#FAFAFA><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><U> Test Results </U></B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Date: </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & Date & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Start Time: </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & Environment("T_Start") & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test End Time: </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & Now & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Duration: </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vDura & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#A2B3F0 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Total No Scripts executed </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & (getRowNumber-1) & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#A2B3F0 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Passed </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vPass & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#A2B3F0 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Failed </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vFail & "</B></FONT></TD></TR>"
    var_objReport.Write "<TR COLS=2><TD BGCOLOR=#A2B3F0 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Not Completed </B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>" & vNotComp & "</B></FONT></TD></TR>"
    var_objReport.Write "</TABLE></BODY></HTML>"
    var_objReport.Close
    Set var_objFS = Nothing
    Set var_objReport = Nothing
   	' HTML Reporting END for Summary file (Temp)

End Function

'****************************************************************************************************************************************
'Script Name				: SAFE_FailedStepDesc
'Description 				: This is the function to get description for failed step
'Created By 				: K Saurabh 
'Creation start Date		: Nov 21, 2014
'Updated By 				: 
'Updated Date 				: 
'****************************************************************************************************************************************
Function SAFE_FailedStepDesc(failuremessage)
	Set myxl7 = createobject("excel.application")		
	Set objWorkbook7 = myxl7.Workbooks.Open(failedstepdescpath)
	objWorkbook7.Worksheets(1).Select
	Set objworksheet7=myxl7.ActiveWorkbook.Worksheets(1)
	objworksheet7.cells(1,1).value="Description"
	objworksheet7.cells(1,2).value="RowNumber"
	rownum_failedstep=objworksheet7.usedrange.rows.count
	For i=2 to rownum_failedstep+1
		If objworksheet7.cells(i,1).value=empty Then
			objworksheet7.cells(i,1).value=failuremessage
		Exit for
	End If
	Next
'	objworksheet.cells(rownum_failedstep+1,1).value=failuremessage
	objWorkbook7.Worksheets(1).Columns("A:B").WrapText = True
    objWorkbook7.Worksheets(1).Columns("A:B").ColumnWidth = 15
	objWorkbook7.Worksheets(1).usedrange.rows.Borders(1).LineStyle = 1
	objWorkbook7.Worksheets(1).usedrange.rows.Borders(2).LineStyle = 1
	objWorkbook7.Worksheets(1).usedrange.rows.Borders(3).LineStyle = 1
	objWorkbook7.Worksheets(1).usedrange.rows.Borders(4).LineStyle = 1	
	myxl7.ActiveWorkbook.Save
	Set objWorkbook7=nothing
	Set objworksheet7=nothing
	myxl7.Quit
	Set myxl7 = Nothing
End Function


'*****************************************************************************************************
'FunctionName:SAFE_Reporting
'Description ': This function will  display  the report
'Parameters:
'1) micRes: Status(pass,fail,done)
'2) Desc: "Description 
'3)strResult: Result  
' Created By : K Saurabh 
' Creation Date : 22 Sep 2014
' Updated Date : 
' Return  type : 
'*****************************************************************************************************
Public Function SAFE_Reporting(micRes,  Desc, strResult)
	
	If micRes = Empty Then
		Reporter.ReportEvent micFail, "micRes parameter is blank in SAFE_Reportingeporting Function", "micRes is Empty"
		Exit Function
	End If
	If Desc = Empty Then
		Reporter.ReportEvent micFail, "Desc parameter is blank in SAFE_Reporting Function", "Desc is Empty"
		Exit Function
	End If
	If strResult = Empty Then
		Reporter.ReportEvent micFail, "strResult parameter is blank in SAFE_Reporting Function", "strResult is Empty"
		Exit Function
	End If

	SAFE_Reporting = Empty
	Select Case LCase(Trim(micRes))
		Case "pass"
			Reporter.ReportEvent micPass, Desc, strResult
		Case "fail"
			Reporter.ReportEvent micFail,Desc, strResult
			Call MV_UpdateLogsFile(Desc,strResult)
		Case "done"
			Reporter.ReportEvent micDone,Desc, strResult
	End Select
	
End Function



'****************************************************************************************************************************************
'Script Name				: SAFE_DeleteColumn
'Description 				: This is the function to delete or reset specific column in excel file
'Created By 				: K Saurabh 
'Creation start Date		: Nov 25, 2014
'Updated By 				: K Saurabh - Inserting deleted row as well without data
'Updated Date 				: Nov 29, 2014
'****************************************************************************************************************************************
Function SAFE_DeleteColumn(FileNamewithPath,column_number)
	Set myxl1 = createobject("excel.application")
	Set objWorkbook = myxl1.Workbooks.Open(FileNamewithPath)
	numberofSheet=objWorkbook.Worksheets.Count
	For intsheet1 = 1 To numberOfSheet
		Set objWorksheet = myxl1.ActiveWorkbook.Worksheets(intsheet1)
		'objWorksheet.columns(column_number & ":" & column_number).delete
		objWorksheet.columns(column_number & ":" & column_number).clear
		'objWorksheet.columns(column_number & ":" & column_number).insert xlToRight
	next
	myxl1.ActiveWorkbook.Save
	myxl1.Application.Quit
	Set objWorkbook=nothing
	Set objWorksheet=nothing
	Set myxl1=nothing
End Function


'**************************************************
' HTML Functions below as per SAFE Reporting need '''''
'**************************************************
'#################################################################################
' About : Delcaration of Constans and Variables
'#################################################################################~~
Public var_sFileName  'Report Log File Name.
Public var_iCapture_Count  'Number of Images captured
Public var_iImage_Capture  'Flag for Image Capture in Result File
Public var_iPass_Count  'Pass Count
Public var_iFail_Count  'Fail Count
Public var_tStart_Time  'Start Time
Public var_tEnd_Time  'End Time
'Environment("ResultDir") = "E:\Automation\Temp"

'#################################################################################~~
' About : Procedure to Open a HTML File for Report Log
'#################################################################################~~
Public Sub HTMLRep_Open_Main_File(sFileName)
   Dim var_objReport 'File Object
   Dim var_objFS  'File System Object
   var_iPass_Count = 0
   var_iFail_Count = 0
   var_sFileName = sFileName
   'var_iImage_Capture = iImageCapture
   Set var_objFS = CreateObject("Scripting.FileSystemObject")
   If NOT(var_objFS.FolderExists(var_objFS.GetParentFolderName(sFileName))) Then
	    var_objFS.CreateFolder(var_objFS.GetParentFolderName(sFileName))
	End If
   Set var_objReport = var_objFS.OpenTextFile(var_sFileName, 2, True)
   var_objReport.Write "<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>"
   'var_objReport.Write "<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='" & IMG_LOGO_FILE & "'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=2><B>&nbsp;Test Execution for Release: " & TEST_RELEASE & ", - " & Date & " - " & Time & " on Machine " & Environment.Value("LocalHostName") & "</B></FONT></TD></TR></TABLE>"
   'var_objReport.Write "<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>"
   var_objReport.Close
   Set var_objFS = Nothing
   Set var_objReport = Nothing
   var_tStart_Time = Now()
End Sub

'#################################################################################~~
' About : Procedure to Open a HTML Temp Files for Report Log
'#################################################################################~~
Public Sub HTMLRep_Open_Temp_File(sFileName)
   Dim var_objReport 'File Object
   Dim var_objFS  'File System Object
   'var_sFileName = sFileName
   'var_iImage_Capture = iImageCapture
   Set var_objFS = CreateObject("Scripting.FileSystemObject")
   Set var_objReport = var_objFS.OpenTextFile(sFileName, 2, True)
   var_objReport.Write "<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>"
   var_objReport.Close
   Set var_objFS = Nothing
   Set var_objReport = Nothing
End Sub


'#################################################################################
' About : Procedure to Insert a Section to Report Log
'#################################################################################~~
Public Sub HTMLRep_Insert_Section(sSection)
   Dim var_objReport 'File Object
   Dim var_objFS  'File System Object
   Dim vHREF_Name
   Set var_objFS = CreateObject("Scripting.FileSystemObject")
   Set var_objReport = var_objFS.OpenTextFile(var_sFileName, 8, True)
   vHREF_Name = chr(34) & Trim(Ucase(sSection)) & chr(34)
   var_objReport.Write "<TR><TD COLSPAN=6 BGCOLOR=#A4A4A4><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B><A name =" & vHREF_Name & ">" & sSection & "</B></FONT></TD></TR>"
   var_objReport.Write "<TR COLS=7><TD BGCOLOR=#FFCC99 WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step #</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Description</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Expected Result</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Actual Result</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Result</B></FONT></TD></TR>"
   var_objReport.Close
   Set var_objFS = Nothing
   Set var_objReport = Nothing  
End Sub

'#################################################################################
' About : Procedure to Insert a Step to Report Log
'#################################################################################~~
Public Sub HTMLRep_Insert_Step(sDesc)
   Dim var_objReport 'File Object
   Dim var_objFS  'File System Object
   Set var_objFS = CreateObject("Scripting.FileSystemObject")
   Set var_objReport = var_objFS.OpenTextFile(var_sFileName, 8, True)
   var_objReport.Write "<TR><TD BGCOLOR=#EEEEEE COLSPAN=5><FONT FACE=VERDANA SIZE=2><B>" & sDesc1 & "</B></FONT></TD></TR>"
   var_objReport.Close
   Set var_objFS = Nothing
   Set var_objReport = Nothing  
End Sub

'#################################################################################' 'About : Procedure to Insert a Result to Report Log
'#################################################################################
Public Sub HTMLRep_Insert_Result(sTestName, sStepNo, sDesc, sExpected, sActual, sResult)
   Dim var_objReport 'File Object
   Dim var_objFS  'File System Object
   Dim l_sFile  'Bitmap File Name
   Set var_objFS = CreateObject("Scripting.FileSystemObject")
   Set var_objReport = var_objFS.OpenTextFile(var_sFileName, 8, True)
   ' If IMAGE_CAPTURE variable in GLOBAL VARIABLE file is set to 1, then only for "FAIL" or "Not Completed" tests, screen capture will happen. 
   ' For 2, it will be both "PASS" & "FAIL".
   If UCASE(sResult)="PASS" Then
     var_iPass_Count = var_iPass_Count + 1
     If IMAGE_CAPTURE=2 Then
'       l_sFile = Environment("ResultDir") & "\TC_" & sTestName & var_iCapture_Count & ".png"
 l_sFile = Environment("Respath") & "\TC_" & sTestName & var_iCapture_Count & ".png"
	   Desktop.CaptureBitmap l_sFile
       var_iCapture_Count = var_iCapture_Count + 1
       var_objReport.Write "<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>" & sStepNo & "<TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sDesc & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sExpected & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=WINGDINGS SIZE=4>2</FONT><FONT FACE=VERDANA SIZE=2><A HREF='" & l_sFile & "'>" & sActual & "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=7%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" & sResult & "</FONT></TD></TR>"
	   'Reporter.ReportEvent micPass,sDesc,sActual
     Else
       var_objReport.Write "<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>" & sStepNo & "<TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sDesc & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sExpected & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sActual & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=7%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" & sResult & "</FONT></TD></TR>"
       'Reporter.ReportEvent micPass,sDesc,sActual
     End If
   ElseIf UCASE(sResult)="FAIL" Then
     var_iFail_Count = var_iFail_Count + 1
     If IMAGE_CAPTURE=1  Or IMAGE_CAPTURE=2 Then
'       l_sFile = Environment("ResultDir") & "\TC_" & sTestName & var_iCapture_Count & ".png"
 l_sFile = Environment("Respath") & "\TC_" & sTestName & var_iCapture_Count & ".png"
       
	   Desktop.CaptureBitmap l_sFile
       var_iCapture_Count = var_iCapture_Count + 1
       var_objReport.Write "<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>" & sStepNo & "<TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sDesc & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sExpected & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=WINGDINGS SIZE=4>2</FONT><FONT FACE=VERDANA SIZE=2><A HREF='" & l_sFile & "'>" & sActual & "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=7%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=RED>O</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" & sResult & "</FONT></TD></TR>"
       'Reporter.ReportEvent micFail,sDesc,sActual
     Else
       var_objReport.Write "<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>" & sStepNo & "<TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sDesc & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sExpected & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sActual & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=7%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=RED>O</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" & sResult  & "</FONT></TD></TR>"
       'Reporter.ReportEvent micFail,sDesc,sActual
     End If
   Else
     var_objReport.Write "<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>" & sStepNo & "<TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sDesc & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sExpected & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=25%><FONT FACE=VERDANA SIZE=2>" & sActual & "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=7%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=RED>O</FONT><FONT FACE=VERDANA SIZE=2 COLOR=BLACK><B>" & sResult & "</FONT></TD></TR>"
     'Reporter.ReportEvent micGeneral,sDesc,sActual
   End If
   var_objReport.Close
   Set var_objFS = Nothing
   Set var_objReport = Nothing
End Sub

'#################################################################################' 
'About : Procedure to Close Report Log
'#################################################################################
Public Sub HTMLRep_Close
   Dim var_objReport 'File Object
   Dim var_objFS  'File System Object
   Set var_objFS = CreateObject("Scripting.FileSystemObject")
   Set var_objReport = var_objFS.OpenTextFile(var_sFileName, 8, True)
   var_tEnd_Time = Now()
   var_objReport.Write "<TR COLS=5><TD BGCOLOR=BLACK WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Pass Count : " & var_iPass_Count & "</B></FONT></TD><TD BGCOLOR=BLACK WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Fail Count : " & var_iFail_Count & "</B></FONT></TD><TD BGCOLOR=BLACK WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Time Taken : " & DateDiff("n",var_tStart_Time,var_tEnd_Time) & " Minutes</B></FONT></TD><TD BGCOLOR=BLACK WIDTH=7%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B></B></FONT></TD><TD BGCOLOR=BLACK WIDTH=18%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B></B></FONT></TD></TR>"
   var_objReport.Write "</TABLE></BODY></HTML>"
   var_objReport.Close
   Set var_objFS = Nothing
   Set var_objReport = Nothing   
End Sub

'#################################################################################
' About : Procedure to Show Report Log in Browser Window
'#################################################################################~~
Public Sub HTMLRep_Show_Result(sHTMLFile)
  'HTMLRep_Close
  Set objIE = CreateObject("InternetExplorer.Application") ' Creating a new object for IE
  objIE.Visible = True 'Setting the visible property to true
  objIE.Navigate sHTMLFile
End Sub

'*********************************************************************

Function FnSendMailusingCDONew(toEmail, fromEmail, subjectEmail, htmlPathEmail, sSendToCC, sSendToBCC)

Set objExcel = CreateObject("Excel.Application")

objExcel.Workbooks.Open("Y:\SAFE_Automation\Report\CDOMail.xlsm")
objExcel.Visible = False

objExcel.Run "SendEmail", toEmail, fromEmail, subjectEmail, htmlPathEmail, sSendToCC, sSendToBCC

set objExcel= nothing

end Function




'#################################################################################
' About : Function to create Outlook format email and send along with results in email body
'#################################################################################~~



Function FnAttachHTMLAsMailContent(sSendTo, sSendToCC, sSendToBCC, sSubject, sHtmlPath)


'calling New function
FnSendMailusingCDONew sSendTo,"nanda.nandyal@nbcuni.com",sSubject,sHtmlPath,sSendToCC,sSendToBCC

	
End Function


Sub CDO_Mail_Small_Text ()
'	Dim iMsg  
'    Dim iConf  
'    Dim strbody
'    '    Dim Flds As Variant
'
'    Set iMsg = CreateObject("CDO.Message")
'    Set iConf = CreateObject("CDO.Configuration")
'
'    '    iConf.Load -1    ' CDO Source Defaults
'    '    Set Flds = iConf.Fields
'    '    With Flds
'    '        .Item("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2
'    '        .Item("http://schemas.microsoft.com/cdo/configuration/smtpserver") _
'    '                       = "Fill in your SMTP server here"
'    '        .Item("http://schemas.microsoft.com/cdo/configuration/smtpserverport") = 25
'    '        .Update
'    '    End With
'
'    strbody = "Hi there" & vbNewLine & vbNewLine & _
'              "This is line 1" & vbNewLine & _
'              "This is line 2" & vbNewLine & _
'              "This is line 3" & vbNewLine & _
'              "This is line 4"
'
'    With iMsg
'        Set .Configuration = iConf
'        .To = "ron@debruin.nl"
'        .CC = ""
'        .BCC = ""
'        .From = """Ron"" <ron@something.nl>"
'        .Subject = "New figures"
'        .TextBody = strbody
'        .Send
'    End With

End Sub 


'****************************************************************************************************************************************
'Script Name				: FnGmail_CDO_Notification
'Description 				: This is the function to send Email using GMAIL with test results
'Created By 				: K Saurabh 
'Creation start Date		: Feb 5, 2015
'Updated By 				:
'Updated Date 				: 
'****************************************************************************************************************************************

Function FnGmail_CDO_Notification(sSendTo, sSendToCC, sSendToBCC, sSubject, sHtmlPath)
'	Const cdoSendUsingPickup = 1 'Send message using the local SMTP service pickup directory. 
'	Const cdoSendUsingPort = 25 'Send the message using the network (SMTP over the network). 
'	Const cdoSMTPserver = "mailrelay.nbcuni.ge.com"
'	
'	Const cdoAnonymous = 0 'Do not authenticate
'	Const cdoBasic = 1 'basic (clear-text) authentication
'	Const cdoNTLM = 2 'NTLM
'	
'	Set objMessage = CreateObject("CDO.Message") 
'	objMessage.Subject = "Example CDO Message" 
'	objMessage.From = """SAFE AUTOMATION QA"" <kumar.saurabh@nbcuni.com>" 
'	objMessage.To = sSendTo
'	objMessage.CC = sSendToCC
'	objMessage.BCC = sSendToBCC
'	'objMessage.TextBody = "This is some sample message text.." & vbCRLF & "It was sent using SMTP authentication and SSL."
'	objMessage.Subject =sSubject
'	
'	' Body of the message
'	With objMessage
'		Set fso = CreateObject("Scripting.FileSystemObject")
'		Set ts = fso.OpenTextFile(sHtmlPath, 1)
'		strText = ts.ReadAll
'		.HTMLBody = strText  
'		'.Display
'	End With
'	'==This section provides the configuration information for the remote SMTP server.
'	schema = "http://schemas.microsoft.com/cdo/configuration/"
'    flds.Item(schema & "sendusing") = cdoSendUsingPort
'    flds.Item(schema & "smtpserver") = cdoSMTPserver
'    flds.Item(schema & "smtpserverport") = cdoSendUsingPort
'    flds.Item(schema & "smtpauthenticate") = cdoBasic
'    flds.Item(schema & "sendusername") = "kumar.saurabh@nbcuni.com"
'    flds.Item(schema & "sendpassword") = "Octane1234Admin"
'    flds.Item(schema & "smtpusessl") = False
'    flds.Update
    
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/sendusing") = cdoSendUsingPort
'	
'	'Name or IP of Remote SMTP Server
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/smtpserver") = cdoSMTPserver
'	
'	'Type of authentication, NONE, Basic (Base64 encoded), NTLM
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/smtpauthenticate") = cdoBasic
'	
''	'Your UserID on the SMTP server
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/sendusername") = """SAFE AUTOMATION QA"" <kumar.saurabh@nbcuni.com>" 
''	
''	'Your password on the SMTP server
''	objMessage.Configuration.Fields.Item _
''	("http://schemas.microsoft.com/cdo/configuration/sendpassword") = "Pa55@word"
''	
''	'Server port (typically 25)
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/smtpserverport") = cdoSendUsingPort 
'	
'	'Use SSL for the connection (False or True)
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/smtpusessl") = True
'	
'	'Connection Timeout in seconds (the maximum time CDO will try to establish a connection to the SMTP server)
'	objMessage.Configuration.Fields.Item _
'	("http://schemas.microsoft.com/cdo/configuration/smtpconnectiontimeout") = 60
'	
'	objMessage.Configuration.Fields.Update
	
	'==End remote SMTP server configuration section==
	
	objMessage.Send
	Wait (2)
	Set objMessage = Nothing
End Function

'****************************************************************************************************************************************
'Script Name				: SAFE_DeleteColumn
'Description 				: This is the function to delete or reset specific column in excel file
'Created By 				: K Saurabh 
'Creation start Date		: Nov 25, 2014
'Updated By 				: K Saurabh - Inserting deleted row as well without data
'Updated Date 				: Nov 29, 2014
'****************************************************************************************************************************************

Function FnOutlookEmailNotification(sSendTo, sSendToCC, sSendToBCC, sSubject, strMsg)
	Dim objOutlook,objOutlookMsg, olMailItem
	
	' Create the Outlook object and the new mail object.
	Set objOutlook = CreateObject("Outlook.Application")
	Set objOutlookMsg = objOutlook.CreateItem(olMailItem)
	
	' Define mail recipients
	objOutlookMsg.To = sSendTo
	objOutlookMsg.CC = sSendToCC
	objOutlookMsg.BCC = sSendToBCC
	objOutlookMsg.Subject =sSubject
	objOutlookMsg.HTMLBody = strMsg
	
	' Body of the message
'	With objOutlookMsg
'		Set fso = CreateObject("Scripting.FileSystemObject")
''		Set ts = fso.OpenTextFile(sHtmlPath, 1)
''		strText = ts.ReadAll
'		.HTMLBody = strMsg  
'		.Display
'	End With
	
	' Send the message
	objOutlookMsg.Send
	Wait (3)
	' Release the objects
	Set objOutlook = Nothing
	Set objOutlookMsg = Nothing
End Function

'Call FnOutlookEmailNotification("kumar.saurabh@nbcuni.com", "kumar1.saurabh@birlasoft.com", "", "Automation Results", "Test Failed as Login was not successful.")
'Call FnAttachHTMLAsMailContent("kumar.saurabh@nbcuni.com", "kumar1.saurabh@birlasoft.com", "", "Automation Results", sFileName)
