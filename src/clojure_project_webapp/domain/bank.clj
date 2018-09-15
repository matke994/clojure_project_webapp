(ns clojure-project-webapp.domain.bank
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

(defn allBanks []
  (jdbc/query mysql-db
              ["SELECT * FROM bank b"]))

(defn removeBank [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM bank WHERE bank_id = ?" id]))

(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM bank WHERE bank_id = ?" id])))


(defn update [id params]
  (jdbc/update! mysql-db :bank params (sql/where {:bank_id id})))


(defn insertBank
  [params]
  (jdbc/insert! mysql-db :bank params))
