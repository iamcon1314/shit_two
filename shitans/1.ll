target datalayout = "e-m:e-p:32:32-p270:32:32-p271:32:32-p272:64:64-f64:32:64-f80:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"


declare dso_local i8* @malloc(i32)
declare dso_local i8* @strcpy(i8*, i8*)
declare dso_local i8* @strcat(i8*, i8*)
declare dso_local i32 @strlen(i8*)
declare void @print(i8*)
declare void @println(i8*)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare i8* @getString()
declare i32 @getInt()
declare i8* @toString(i32)
declare i8* @__mx_substring(i8*, i32, i32)
declare i32 @__mx_parseInt(i8*)
declare i32 @__mx_ord(i8*, i32)
declare i8 @__mx_strlt(i8*, i8*)
declare i8 @__mx_strle(i8*, i8*)
declare i8 @__mx_strgt(i8*, i8*)
declare i8 @__mx_strge(i8*, i8*)
declare i8 @__mx_streq(i8*, i8*)
declare i8 @__mx_strneq(i8*, i8*)

define i32 @gbzs(i32 %0, i32 %1) {
entry_0:
  %2 = alloca i32
  %3 = alloca i32
  %retval = alloca i32
  store i32 %0, i32* %2
  store i32 %1, i32* %3
  %4 = load i32, i32* %3
  store i32 %4, i32* %retval
  br label %return_1
return_1:
  %5 = load i32, i32* %retval
  ret i32 %5
}

define i32 @main() {
entry_0:
  %retval = alloca i32
  %0 = call i32 @gbzs(i32 4, i32 8)
  store i32 0, i32* %retval
  br label %return_1
return_1:
  %1 = load i32, i32* %retval
  ret i32 %1
}

