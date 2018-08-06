(ns clojure-project-webapp.domain.transaction
    (:refer-clojure :exclude [get])
    (:require [clojure.java.jdbc :as jdbc]
      [clojure.java.jdbc.sql :as sql]))

(def mysql-db {
               :subprotocol "mysql"
               :subname "//localhost:3306/clojure_database"
               :user "root"
               :password ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(def now (str (java.sql.Timestamp. (System/currentTimeMillis))))

(defn allTransactions []
      (jdbc/query mysql-db
                  ["SELECT * FROM transaction t"]))

(defn get [id]
      (first (jdbc/query mysql-db
                         ["SELECT * FROM transaction WHERE TXN_ID = ?" id])))


(defn removeTransaction [id]
      (jdbc/execute! mysql-db
                     ["DELETE FROM transaction WHERE TXN_ID = ?" id]))


(defn update [id params]
      (jdbc/update! mysql-db :transaction params (sql/where {:TXN_ID id})))

(defn insertTransaction
      [params]
      (jdbc/insert! mysql-db :transaction params))
