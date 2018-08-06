(ns clojure-project-webapp.domain.file
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

(defn allFiles []
  (jdbc/query mysql-db
              ["SELECT * FROM file f"]))

(defn removeFile [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM file WHERE FILE_ID = ?" id]))

(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM file WHERE FILE_ID = ?" id])))


(defn update [id params]
  (jdbc/update! mysql-db :file params (sql/where {:FILE_ID id})))


(defn insertFile
  [params]
  (jdbc/insert! mysql-db :file params))
