(ns {{name}}.views.index
  (:use [hiccup.core]))

(defn index []
  (html
   "<!DOCTYPE html>"
   [:html
    [:head]
    [:body
     ;; [:script {:src "externs.js"}]
     [:script {:src "js/app.js"}]
     [:script "{{name}}.core.main()"]]]))
