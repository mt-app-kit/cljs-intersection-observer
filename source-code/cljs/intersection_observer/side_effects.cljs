
(ns intersection-observer.side-effects
    (:require [dom.api :as dom]
              [intersection-observer.state :as state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn setup-observer!
  ; @param (keyword) observer-id
  ; @param (map) observer-props
  ; {:callback-f (function)
  ;  :get-element-f (function)
  ;   Takes the observer ID as parameter.
  ;   Must return a DOM Element object.}
  ;
  ; @usage
  ; (setup-observer! :my-observer {:callback-f    (fn [intersecting?] ...)
  ;                                :get-element-f (fn [_] (.getElementById js/document "my-element"))})
  ; =>
  ; #object[IntersectionObserver]
  ;
  ; @return (JS IntersectionObserver object)
  [observer-id {:keys [callback-f get-element-f]}]
  (if get-element-f (if-let [element (get-element-f observer-id)]
                            (let [observer (dom/setup-intersection-observer! element callback-f)]
                                 (-> state/OBSERVERS (swap! assoc observer-id observer))
                                 (-> observer)))))

(defn remove-observer!
  ; @param (keyword) observer-id
  ;
  ; @usage
  ; (remove-observer! :my-observer)
  ; @param (map) observer-props
  ; {:get-element-f (function)
  ;   Takes the observer ID as parameter.
  ;   Must return a DOM Element object.}
  ;
  ; @usage
  ; (remove-observer! :my-observer {:get-element-f (fn [_] (.getElementById js/document "my-element")})
  ; =>
  ; #object[IntersectionObserver]
  ;
  ; @return (JS IntersectionObserver object)
  [observer-id {:keys [get-element-f]}]
  (if get-element-f (if-let [element (get-element-f observer-id)]
                            (when-let [observer (get @state/OBSERVERS observer-id)]
                                      (-> state/OBSERVERS (swap! dissoc observer-id))
                                      (-> observer (dom/remove-intersection-observer! element))
                                      (-> observer)))))
