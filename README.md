# NAGP 2025 Kubernetes and Devops

### _Important links_
* [Github Repository](https://github.com/yankit-chauhan/NAGP-2025-Devops)
* [Database Tier Docker Image](https://hub.docker.com/layers/library/mysql/8.0.0/images/sha256-228d71078f8ce5ae9fd96b183f88c3a90e30544b4b7ce9d64a238d05fef2a681)
* [Service API Tier Docker Image](https://hub.docker.com/repository/docker/yankitchauhan/product-service/general)


Kubernetes objects files are placed inside kubernetes folder in root directory:
* app-config.yaml
* mysql-config.yaml
* mysql-secret.yaml
* mysql-pvc.yaml
* mysql-deployment.yaml
* mysql-service.yaml
* app-deployment.yaml 
* app-service.yaml 
* ingress.yaml

### _Database Tier deployment_
* Create the kubernetes standard cluster.
* Inside kubernetes folder run commands in the same order as defined below
  * kubectl apply -f app-config.yaml 
  * kubectl apply -f mysql-config.yaml 
  * kubectl apply -f mysql-secret.yaml 
  * kubectl apply -f mysql-pvc.yaml 
  * kubectl apply -f mysql-deployment.yaml 
  * kubectl apply -f mysql-service.yaml
* Initial 6 records will be added as a part of deployment defined in mysql-config.yaml.

### _Service API Tier deployment_
* Now to deploy the java service run below commands in the below defined order:
  * kubectl apply -f app-deployment.yaml 
  * kubectl apply -f app-service.yaml

### _Enable Ingress_
* Run below commands in the below defined order:
  * kubectl create clusterrolebinding cluster-admin-binding \
    --clusterrole cluster-admin \
    --user $(gcloud config get-value account)
  * kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.13.0/deploy/static/provider/cloud/deploy.yaml
  * Run command get the Ingress External-IP to be used to call the APIs **kubectl get svc -n ingress-nginx**

### _URL for Service API tier_
* http://product-service.{{host_url}}.nip.io - replace {{host_url}} with the ingress External-IP

### _Service API Tier Endpoints_
Postman collection is committed in the repository(postman collection/NAGP Devops.
postman_collection.json), {{host_url}} is defined in the environment variables of the collection 
(change the value as per newly generated ingress External-IP) or replace it directly in the api.
* GET http://product-service.{{host_url}}.nip.io/v1/products/{id}
* GET http://product-service.{{host_url}}.nip.io/v1/products
* POST http://product-service.{{host_url}}.nip.io/v1/products
* PUT http://product-service.{{host_url}}.nip.io/v1/products/{id}
* DELETE http://product-service.{{host_url}}.nip.io/v1/products/{id}