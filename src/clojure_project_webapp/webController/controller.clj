(ns clojure-project-webapp.webController.controller
  (:require
    [clostache.parser :as clostache]
    [clojure-project-webapp.domain.file :as file-domain]
    [clojure-project-webapp.domain.transaction :as transaction-domain]
    [clojure-project-webapp.domain.bank :as bank-domain]
    [clojure-project-webapp.domain.customer :as customer-domain]
    [clojure-project-webapp.domain.bankcustomer :as bankcustomer-domain]
    ))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))


(defn home []
  (render-template "homepage" {}))

(defn index []
  (render-template "index" {}))

(defn allTransactions []
  (render-template "allTransactions" {:transaction (transaction-domain/allTransactions)}))

(defn allFiles []
  (render-template "allFiles" {:file (file-domain/allFiles)}))

(defn allBanks []
  (render-template "allBanks" {:bank (bank-domain/allBanks)}))

(defn allCustomers []
  (render-template "allCustomers" {:customer (customer-domain/allCustomers)}))

(defn transactions[]
  (render-template "transactions" {:transaction (transaction-domain/allTransactions)}))

(defn files []
  (render-template "allFiles" {:file (file-domain/allFiles)}))

(defn updatingTransaction [id]
  (render-template "updateTransaction" {:transaction (transaction-domain/get id)}))

(defn updatingFile [id]
  (render-template "updateFile" {:file (file-domain/get id)}))

(defn updatingBank [id]
  (render-template "updateBank" {:bank (bank-domain/get id)}))

(defn updatingCustomer [id]
  (render-template "updateCustomer" {:customer (customer-domain/get id)}))

(defn allBanksCustomers []
  (render-template "allBanksCustomers" {:bankcustomer (bankcustomer-domain/allBanksCustomers)}))


