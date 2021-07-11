## Deployment of Spring Boot application in RedHat OpenShift 

This demo illustrates deploying a Spring Boot application in RH OpenShift container service
using Tekton pipeline. The helm chart is included to perform
the deployment.

## Demo functions
This sample demonstrates a simple example of adding, deleting 
and listing customers from an in-memory H2 database 
via API endpoint. For example, using Httpie, you can do the following:
* `http http://localhost:8080/customers` to list customers (id and a name)
* `http POST http://localhost:8080/customers/Sam` to add a customer with a name `Sam`

## Deployment Steps
* Push this application to a remote repository that your cluster can reach (GitHub, local Gogs, etc.)
* Login to your cluster `icc <cluster name>`    
  ```If ICC doesn't work for you open the OpenShift Web Console and login via "Copy Login Command"```
* Change directory to the project root and create a project `oc sync <project name>`
* Create the pipeline `oc pipeline --tekton`
  * Select the Pipeline to use in the Pipeline Run: choose the most appropriate pipeline for your project
    For this Java project, choose `Java Maven`
  * Image scan (y/n) type n
  * Lint dockerfile (y/n) type n

If successful, the Pipeline Run URL is printed out. CMD+click on the URL to open in your default browser and see if the pipeline passes or fails.

* Run oc console to open a console
* In the sidebar, go to Pipelines
* Click the latest Pipeline Run
* Verify that the build is successful    