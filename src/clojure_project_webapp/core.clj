(ns clojure-project-webapp.core

  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [ring.util.response :as resp]
            [clojure-project-webapp.domain.file :as file-domain]
            [clojure-project-webapp.domain.transaction :as transaction-domain]
            [clojure-project-webapp.webController.controller :as controller]))


(defroutes public-routes
           (GET "/" [] (controller/index))
           (route/resources "/")
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/homepage" [] (controller/home))
           (route/resources "/")
           (GET "/allTransactions" [] (controller/allTransactions))
           (route/resources "/")
           (GET "/allFiles" [] (controller/allFiles))
           (route/resources "/")

           (GET "/domain/transactions/:id/remove" [id]
             (do (transaction-domain/removeTransaction id)
                 (resp/redirect "/allTransactions")))

           (GET "/domain/files/:id/remove" [id]
             (do (file-domain/removeFile id)
                 (resp/redirect "/allFiles")))

           (POST "/domain/transactions/insert" [& params]
             (do (transaction-domain/insertTransaction params)
                 (resp/redirect "/allTransactions")))

           (POST "/domain/files/insert" [& params]
             (do (file-domain/insertFile params)
                 (resp/redirect "/allFiles")))

           (GET "/domain/transactions/:id/update" [id]
             (controller/updatingTransaction id))

           (POST "/domain/transactions/:TXN_ID/update" [& params]
             (do (transaction-domain/update (:TXN_ID params) params)
                 (resp/redirect "/allTransactions")))

           (GET "/domain/files/:id/update" [id]
             (controller/updatingFile id))

           (POST "/domain/files/:FILE_ID/update" [& params]
             (do (file-domain/update (:FILE_ID params) params)
                 (resp/redirect "/allFiles")))

           )




(defroutes app-routes
           public-routes
           (route/not-found "404. Page not found"))

(def -main
  (handler/site app-routes))