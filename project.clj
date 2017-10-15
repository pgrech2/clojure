(defproject clojure_practice "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
  				 [cheshire "5.7.0"]]
  :resource-paths ["resources"]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}})
