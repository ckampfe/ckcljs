(ns {{name}}.core
  (:require [{{name}}.views.index]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as jetty]))

(defroutes app-routes
  (GET "/" [] ({{name}}.views.index/index))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn -main [& args]
  jetty/run-jetty #'app {:host "127.0.0.1"
                         :port 5000
                         :join? false})
