(ns clojure-practice.brave-true.chpt6.core)
;;;; Ensure that the SVG code is evaluated
;;(require ['the-divine-cheese-code.visualization.svg :as 'svg] )

;;;; Refer the namespace so that you don't have to use the
;;;; fully qualified name to reference svg functions
;;(require 'the-divine-cheese-code.visualization.svg)
;;(refer 'the-divine-cheese-code.visualization.svg)
;;(alias 'svg 'the-divine-cheese-code.visualization.svg)

;;;; Or we can use the use function
;;(use ['the-divine-cheese-code.visualization.svg :as 'svg])

;; Require/refer allows you to pull in functions conditionally
;;(require 'the-divine-cheese-code.visualization.svg)
;;(refer 'the-divine-cheese-code.visualization.svg :only ['points])
;;(alias 'svg 'the-divine-cheese-code.visualization.svg)


;; An even better way of doing this
(ns the-divine-cheese-code.core
  (:require [the-divine-cheese-code.visualization.svg :as svg]))



(def heists [{:location "Cologne, Germany"
              :cheese-name "Archbishop Hildebold's Cheese Pretzel"
              :lat 50.95
              :lng 6.97}
             {:location "Zurich, Switzerland"
              :cheese-name "The Standard Emmental"
              :lat 47.37
              :lng 8.55}
             {:location "Marseille, France"
              :cheese-name "Le Fromage de Cosquer"
              :lat 43.30
              :lng 5.37}
             {:location "Zurich, Switzerland"
              :cheese-name "The Lesser Emmental"
              :lat 47.37
              :lng 8.55}
             {:location "Vatican City"
              :cheese-name "The Cheese of Turin"
              :lat 41.90
              :lng 12.45}])

(defn -main
  [& args]
  (println (points heists)))
