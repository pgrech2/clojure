(ns sample.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;(require 'sample.core)
;((meta #'sample.core/foo))


(defn new-func
	[x]
	(+ x 3))



(map inc [1 2 3])
(map #(inc %) [1 2 3])
(map (fn [x] (-> x inc (str " hello"))) [1 2 3])