(ns chapter5.core
  (:gen-class))

(require '[clojure.string :as s])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn wisdom
  "This is what you need to learn... "
  [new-wisdom]
  (str new-wisdom ", daniel-san!"))

(defn clean
  "This is how you clean a string"
  [my-string]
  (s/replace (s/trim my-string) #"lol" "LOL"))


;;---------------------------------------------
;; Composition Example
(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})
(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

;; same as spell-slots but using
;; anonymous functinof or the division
;; comp to append functions together
(def spell-slots-comp (comp int inc #(/ % 2) c-int))

;; Raw implementation
(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))


;;------------------------------------------------------------
;; Memoization
(defn sleepy-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)
;; (def memo-sleepy-identity (memoize sleepy-identity))

