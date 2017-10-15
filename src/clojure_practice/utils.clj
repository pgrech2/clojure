(ns clojure-practice.utils)


(defn char-seq
  [s]
  (map str (seq s)))

(defn char-vec
  [s]
  (mapv str (char-array s)))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn digits [n]
  (->> (iterate #(quot % 10) n)
       (take-while pos?)
       (mapv #(mod % 10))))

(defn palindrome? [coll]
  (= coll (reverse coll)))
