网上查阅资料：
1.Jenkins API 中文文档：https://blog.csdn.net/nklinsirui/article/details/80832005
2.Jenkins常用接口汇总：https://blog.csdn.net/weixin_33320453/article/details/85713503
3.JenkinsAPI：https://jenkinsapi.readthedocs.io/en/latest/api.html#jenkinsapi.api.get_latest_complete_build

自己实践的API整理：
一.Jenkins构建任务触发：
(注意：JOB_NAME是构建工程名，使用时需替换)
1.不带参构建(普通构建)：http://192.168.43.110:8080/jenkins/job/JOB_NAME/build
2.带参构建(&表示带有多个参数)：http://192.168.43.110:8080/jenkins/job/JOB_NAME/buildWithParameters?ParameterName1=ParameterValue1&ParameterName2=ParameterValue2

二.增删改查project：
1.