(ns leiningen.new.ckcljs
  (:require [leiningen.new.templates :refer [renderer name-to-path
                                             ->files sanitize-ns
                                             multi-segment]]
            [leiningen.core.main :as main]))

(def render (renderer "ckcljs"))

(defn ckcljs
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info (str "Generating fresh 'lein new' ckcljs project in " name))
    (->files data
             [".gitignore" (render ".gitignore" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/clj/{{sanitized}}/views/index.clj" (render "index.clj" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)])))
