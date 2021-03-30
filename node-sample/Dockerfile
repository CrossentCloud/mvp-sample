ARG NODE_VERSION=14.16.0-alpine3.12
ARG NGINX_VERSION=1.13.12-alpine

#=========================================================#
# Builder #
#=========================================================#
FROM harbor.clap.crossent.com/library/node:$NODE_VERSION AS builder

WORKDIR /home/node/app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

#=========================================================#
# Runtime #
#=========================================================#
FROM harbor.clap.crossent.com/library/nginx:$NGINX_VERSION

WORKDIR /home/node/app

COPY --from=builder /home/node/app/dist /usr/share/nginx/html 

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

