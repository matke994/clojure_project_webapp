(ns clojure-project-webapp.core

  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [ring.util.response :as resp]
            [clojure-project-webapp.domain.file :as file-domain]
            [clojure-project-webapp.domain.transaction :as transaction-domain]
            [clojure-project-webapp.domain.bank :as bank-domain]
            [clojure-project-webapp.domain.customer :as customer-domain]
            [clojure-project-webapp.webController.controller :as controller]))


(defroutes public-routes
           (GET "/" [] (controller/index))
           (route/resources "/")
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/transactions" [] (controller/transactions))
           (route/resources "/")
           (GET "/homepage" [] (controller/home))
           (route/resources "/")
           (GET "/allTransactions" [] (controller/allTransactions))
           (route/resources "/")
           (GET "/allFiles" [] (controller/allFiles))
           (route/resources "/")
           (GET "/allBanks" [] (controller/allBanks))
           (route/resources "/")
           (GET "/allCustomers" [] (controller/allCustomers))
           (route/resources "/")


           (GET "/domain/transactions/:id/remove" [id]
             (do (transaction-domain/removeTransaction id)
                 (resp/redirect "/allTransactions")))

           (GET "/domain/files/:id/remove" [id]
             (do (file-domain/removeFile id)
                 (resp/redirect "/allFiles")))

           (GET "/domain/banks/:id/remove" [id]
             (do (bank-domain/removeBank id)
                 (resp/redirect "/allBanks")))

           (GET "/domain/customers/:id/remove" [id]
             (do (customer-domain/removeCustomer id)
                 (resp/redirect "/allCustomers")))

           (POST "/domain/transactions/insert" [& params]
             (do (transaction-domain/insertTransaction params)
                 (resp/redirect "/allTransactions")))

           (POST "/domain/files/insert" [& params]
             (do (file-domain/insertFile params)
                 (resp/redirect "/allFiles")))

           (POST "/domain/banks/insert" [& params]
             (do (bank-domain/insertBank params)
                 (resp/redirect "/allBanks")))

           (POST "/domain/customers/insert" [& params]
             (do (customer-domain/insertCustomer params)
                 (resp/redirect "/allCustomers")))

           (GET "/domain/transactions/:id/update" [id]
             (controller/updatingTransaction id))

           (GET "/domain/banks/:id/update" [id]
             (controller/updatingBank id))

           (GET "/domain/customers/:id/update" [id]
             (controller/updatingCustomer id))

           (POST "/domain/transactions/:TXN_ID/update" [& params]
             (do (transaction-domain/update (:TXN_ID params) params)
                 (resp/redirect "/allTransactions")))

           (POST "/domain/banks/:bank_id/update" [& params]
             (do (bank-domain/update (:bank_id params) params)
                 (resp/redirect "/allBanks")))

           (POST "/domain/customers/:customer_id/update" [& params]
             (do (customer-domain/update (:customer_id params) params)
                 (resp/redirect "/allCustomers")))

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