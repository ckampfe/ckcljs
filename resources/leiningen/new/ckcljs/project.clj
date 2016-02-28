(defproject {{name}} "0.0.1"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [reagent "0.6.0-alpha"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-jetty-adapter "1.4.0"] ]
  :source-paths ["src/clj"]
  :plugins [[lein-ring "0.9.7"]
            [lein-figwheel "0.5.0-4"]
            [lein-cljsbuild "1.1.2"]]
  :resource-paths ["resources" "target/cljsbuild"]
  :cljsbuild {:builds {:app {:figwheel true
                             :source-paths  ["src/cljs"]
                             :compiler      {:output-to "target/cljsbuild/public/js/app.js"
                             :output-dir    "target/cljsbuild/public/js/out"
                             :source-map    true
                             :externs       [;;"react/externs/react.js"
                                             "externs.js"]
                             :optimizations :none
                             :main          "{{name}}.core"
                             :asset-path    "/js/out"
                             :pretty-print  true}}}}
  :figwheel {:nrepl-port 7888
             :nrepl-middleware ["cider.nrepl/cider-middleware"
                                "refactor-nrepl.middleware/wrap-refactor"
                                "cemerick.piggieback/wrap-cljs-repl"]
             :ring-handler {{name}}.core/app
             :port 3000}
  :ring {:handler {{name}}.core/app}
  :main {{name}}.core
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]
                                  [com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.12"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
             :uberjar {:hooks ['leiningen.cljsbuild] :cljsbuild {:jar true
                                                                 :builds {:app
                                                                          {:compiler
                                                                           {:optimizations :advanced
                                                                            :pretty-print false}}}}}})
