def call(String filePath, Closure closure){
def request = libraryResource 'globalconfig.yml'
def map = readYaml text: request

if(!filePath.isEmpty())
{
def file_exist = findFiles (glob: filePath)
if (file_exist.lenght == 1){
def map1 = readYaml file: filePath
map.putAll(map1)

}
}
CommanJenkinsTemplate comjenkins = new CommanJenkinsTemplate(map_var: map)
closure.delegate = comjenkins
closure.resloveStrategy = Closure.DELEGATE_FIRST
closure()
}

def call(Closure closure){
call('',closure)
}
