(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (def body-parts-list [{:name "head" :size 3}
                        {:name "left-eye" :size 1}
                        {:name "left-ear" :size 1}
                        {:name "mouth" :size 1}
                        {:name "nose" :size 1}
                        {:name "neck" :size 2}
                        {:name "left-shoulder" :size 3}
                        {:name "left-upper-arm" :size 3}
                        {:name "chest" :size 10}
                        {:name "back" :size 10}
                        {:name "left-forearm" :size 3}
                        {:name "abdomen" :size 6}
                        {:name "left-kidney" :size 1}
                        {:name "left-hand" :size 2}
                        {:name "left-foot" :size 2}
                        {:name "left-knee" :size 1}])

  (defn needs-matching-part?
    [part]
    (re-find #"^left-" (:name part)))

  (defn make-matching-part
    [part]
    {:name (clojure.string/replace (:name part) #"^left-" "right-")
     :size (:size part)})

  (defn symmetrize-body-parts
    "Expects a seq of maps which have a :name and :size"
    [asym-body-parts]
    (loop [remaining-asym-parts asym-body-parts final-body-parts []]
      (if (empty? remaining-asym-parts)
        final-body-parts
        (let [[part & remaining] remaining-asym-parts
              final-body-parts (conj final-body-parts part)]
          (if (needs-matching-part? part)
            (recur remaining (conj final-body-parts (make-matching-part part)))
            (recur remaining final-body-parts))))))

  (pprint (symmetrize-body-parts body-parts-list)))



