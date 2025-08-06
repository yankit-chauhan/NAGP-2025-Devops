kubectl create clusterrolebinding cluster-admin-binding \
  --clusterrole cluster-admin \
  --user $(gcloud config get-value account)

kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.13.0/deploy/static/provider/cloud/deploy.yaml

kubectl get svc -n ingress-nginx                  

kubectl apply -f app-config.yaml
kubectl apply -f mysql-config.yaml
kubectl apply -f mysql-secret.yaml
kubectl apply -f mysql-pvc.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f mysql-service.yaml


kubectl get configmap
kubectl get secret
kubectl get pvc
kubectl get deploy
kubectl get po
kubectl get svc

kubectl apply -f app-deployment.yaml
kubectl apply -f app-service.yaml

kubectl get deploy
kubectl get po
kubectl get svc

kubectl apply -f ingress.yaml
kubectl get ingress

