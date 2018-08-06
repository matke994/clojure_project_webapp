(ns clojure-project-webapp.core

  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [ring.util.response :as resp]
            [clojure-project-webapp.domain.file :as file-domain]
            [clojure-project-webapp.domain.transaction :as transaction-domain])


  )

(defn -main
  "I don't do a whole lot."
  [x]
  (println x "Hello, Wordl"))
