
(ns intersection-observer.side-effects
    (:require [dom.api                     :as dom]
              [intersection-observer.state :as intersection-observer.state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn setup-observer!
  ; @important
  ; Use this function only when the observed element has been already mounted into the DOM-tree!
  ;
  ; @param (string) element-id
  ; @param (function) callback-f
  ;
  ; @usage
  ; (setup-observer! "my-element" (fn [intersecting?] ...))
  [element-id callback-f]
  (if-let [element (dom/get-element-by-id element-id)]
          (let [observer (dom/setup-intersection-observer! element callback-f)]
               (swap! intersection-observer.state/INTERSECTION-OBSERVERS assoc element-id observer))))

(defn remove-observer!
  ; @param (string) element-id
  ;
  ; @usage
  ; (remove-observer! "my-element")
  ;
  ; @return (undefined)
  [element-id]
  (if-let [element (dom/get-element-by-id element-id)]
          (when-let [observer (get @intersection-observer.state/INTERSECTION-OBSERVERS element-id)]
                    (swap! intersection-observer.state/INTERSECTION-OBSERVERS dissoc element-id)
                    (dom/remove-intersection-observer! observer element))))
