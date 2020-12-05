def call(String filePath, Closure closure){
def request = libraryResource 'globalconfig.yml'
def map = readYaml text: request
println "$request"


CommanJenkinsTemplate comjenkins = new CommanJenkinsTemplate(map_var: map)
closure.delegate = comjenkins
closure.resloveStrategy = Closure.DELEGATE_FIRST
closure()
}

def call(Closure closure){
call('',closure)
}
