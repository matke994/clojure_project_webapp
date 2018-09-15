(ns clojure-project-webapp.domain.customer
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def mysql-db {
               :subprotocol "mysql"
               :subname "//localhost:3306/clojure_database1"
               :user "root"
               :password ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(def now (str (java.sql.Timestamp. (System/currentTimeMillis))))

(defn allCustomers []
  (jdbc/query mysql-db
              ["SELECT * FROM customer b"]))

(defn removeCustomer [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM customer WHERE customer_id = ?" id]))

(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM customer WHERE customer_id = ?" id])))


(defn update [id params]
  (jdbc/update! mysql-db :customer params (sql/where {:customer_id id})))


(defn insertCustomer
  [params]
  (jdbc/insert! mysql-db :customer params))
