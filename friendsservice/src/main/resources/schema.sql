CREATE TABLE public.friend_request
(
  id bigint NOT NULL,
  from_email character varying(255) NOT NULL,
  status character varying(255) NOT NULL,
  to_email character varying(255) NOT NULL,
  CONSTRAINT friend_request_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.friend_request
  OWNER TO postgres;