class CommanJenkinsTemplate{
Map map_var
def commanJenkinsTemplate()
{
 "mvn "+ map_var.builder.maven.goal
}
}
